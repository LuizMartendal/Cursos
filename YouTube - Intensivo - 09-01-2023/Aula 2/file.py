import pandas
import plotly.express as px

# Passo 1: Importaria a base de dados
tabela = pandas.read_csv("telecom_users.csv")

# Passo 2: Vizualizar a base de dados
#   Entender as informações que você tem disponível
#   Descobrir as cagadas da base de dados
tabela = tabela.drop("Unnamed: 0", axis=1)

# Passo 3: Tratamento de Dados
#   Resolver os valores que estão sendo reconhecidos de forma errada
tabela["TotalGasto"] = pandas.to_numeric(tabela["TotalGasto"], errors="coerce")

# Resolver valores vazios

# colunas em que todos os valores são vazios, eu vou excluir
# axis = 0 -> linha, axis=1 -> coluna
tabela = tabela.dropna(how="all", axis=1)

# linhas que tem pelo menos 1 valor vazio (que possuem algum valor vazio)
tabela = tabela.dropna(how="any", axis=0)

# Passo 4: Análise Inicial
print(tabela["Churn"].value_counts())
print(tabela["Churn"].value_counts(normalize=True).map("{:.1%}".format))

# Passo 5: Análise detalhada - descobrir as causas do cancelamento

# comparar  cada coluna da base de dados com a coluna Churn

# cria o gráfico
for coluna in tabela.columns:
    grafico = px.histogram(tabela, x=coluna, color="Churn")
    # exibe o gráfico
    grafico.show()

#   Clientes que tem famílias maiores tendem a cancelar menos
#       Promoções diferenciadas para mais pessoas da mesma família
#   Os clientes nos primeiros meses tem uma tendência Muito maior a cancelar
#       Pode ser algum marketing muito agressivo
#       Pode ser que a experiência nos primeiros meses seja ruim
#       Posso fazer uma promoção de no primeiro ano é mais barato
#   Tem algum problema no serviço de Fibra
#   Quanto mais serviços o cliente tem, menos ele cancela
#       Podemos oferecer mais serviços de graça ou por um preço muito menor
#   Quase todos os cancelamentos estão nos contratos mensais
#   No boleto o cancelamento é muito maior
