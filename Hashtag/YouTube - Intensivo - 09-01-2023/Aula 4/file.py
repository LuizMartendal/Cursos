import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import r2_score

# Importar a base de dados
tabela = pd.read_csv("advertising.csv")

# Criar um gráfico
sns.heatmap(tabela.corr(), cmap="Greens", annot=True)

# Exibe o gráfico
plt.show()

y = tabela["Vendas"]
x = tabela[["TV", "Radio", "Jornal"]]

x_treino, x_teste, y_treino, y_teste = train_test_split(x, y, text_size=0.3)

# Criar a inteligências artificial
modelo_regressaolinear = LinearRegression()
modelo_arvoredecisao = RandomForestRegressor()

# Treinar a inteligência artificial
modelo_regressaolinear.fit(x_treino, y_treino)
modelo_arvoredecisao.fit(x_treino, y_treino)

RandomForestRegressor()

previsao_regressaolinear = modelo_regressaolinear.predict(x_teste)
previsao_arvoredecisao = modelo_arvoredecisao.predict(y_teste)

tabela_auxiliar = pd.DataFrame()
tabela_auxiliar[y_teste] = y_teste
tabela_auxiliar["Previsão árvore desição"] = previsao_arvoredecisao
tabela_auxiliar["Previsao regressão linear"] = previsao_arvoredecisao

