from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import pandas as pd

navegador = webdriver.Chrome()

#   Passo 1: Pegar a cotação do dolar;
navegador.get("https://google.com.br/")

navegador.find_element('xpath', '/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input').send_keys('cotação do dolar')

navegador.find_element('xpath', '/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input').send_keys(Keys.ENTER)

cotacao_dolar = navegador.find_element('xpath', '//*[@id="knowledge-currency__updatable-data-column"]/div[1]/div[2]/span[1]').get_attribute('data-value')
print(cotacao_dolar)

#   Passo 2: Pegar a cotação do euro;
navegador.get("https://google.com.br/")

navegador.find_element('xpath', '/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input').send_keys('cotação do euro')

navegador.find_element('xpath', '/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input').send_keys(Keys.ENTER)

cotacao_euro = navegador.find_element('xpath', '//*[@id="knowledge-currency__updatable-data-column"]/div[1]/div[2]/span[1]').get_attribute('data-value')
print(cotacao_euro)

#   Passo 3: Pegar a cotação do ouro;
navegador.get("https://www.melhorcambio.com/ouro-hoje")

cotacao_ouro = navegador.find_element('xpath', '//*[@id="comercial"]').get_attribute('value')
cotacao_ouro = cotacao_ouro.replace(",", ".")
print(cotacao_ouro)


#   Passo 4: Importar a base;
tabela = pd.read_excel("Produtos.xlsx")

#   Passo 5: Recalcular os preços;
#   Atualizar a cotação
#   Cotação Dolar
tabela.loc[tabela["Moeda"] == "Dolar", "Cotação"] = float(cotacao_dolar)
#   Cotação Euro
tabela.loc[tabela["Moeda"] == "Euro", "Cotação"] = float(cotacao_euro)
#   Cotação Ouro
tabela.loc[tabela['Moeda'] == "Ouro", "Cotação"] = float(cotacao_ouro)

#   Preço de compra = cotação * preço original
tabela["Preço de Compra"] = tabela["Cotação"] * tabela["Preço Original"]

#   Preço de venda = preço de compra * margem
tabela["Preço de Venda"] = tabela["Preço de Compra"] * tabela["Margem"]

#   Exportar a base atualizada;
tabela.to_excel("Produtos-atualizado.xlsx")