import time
import pyperclip
import pyautogui
import pandas as pd


# pyautogui.click -> clicar
# pyautogui.write -> escrever
# pyautogui.press -> pressionar
# pyautogui.hotkey -> atalho

# Passo 1: Entrar no sistema da empresa (no link do drive)
pyautogui.press("win")
time.sleep(3)

pyautogui.write("chrome")
time.sleep(2)

pyautogui.press("enter")
time.sleep(3)

pyautogui.hotkey("win", "UP")
time.sleep(2)

pyperclip.copy("https://drive.google.com/drive/folders/149xknr9JvrlEnhNWO49zPcw0PW5icxga")
pyautogui.hotkey("ctrl", "v")
pyautogui.press("enter")

time.sleep(5)

# Passo 2: Navegar até o local do relatório (entrar na pasta Exportar)
pyautogui.click(x=368, y=304, clicks=2)
time.sleep(3)

# Passo 3: Exportar o relatório (Fazer o download)
pyautogui.click(x=362, y=390)

pyautogui.click(x=1774, y=188)
time.sleep(2)

pyautogui.click(x=1514, y=633)
time.sleep(3)

pyautogui.click(x=783, y=515)
time.sleep(8)
pyautogui.click(x=1898, y=996)

# Passo 4: Calcular os indicadores (faturamento e quantidade de produtos)
tabela = pd.read_excel(r"C:\Users\luizm\Downloads\Vendas - Dez.xlsx")

faturamento = tabela["Valor Final"].sum()
quantidade = tabela["Quantidade"].sum()

# Passo 5: Enviar um e-mail para a diretoria
pyautogui.hotkey("ctrl", "t")
time.sleep(2)

pyautogui.click(x=1718, y=131)
time.sleep(5)

pyautogui.click(x=84, y=209)

destinatario = "rique.martendal@hotmail.com"
pyperclip.copy(destinatario)
time.sleep(1)
pyautogui.hotkey("ctrl", "v")
time.sleep(1)
pyautogui.press("tab")

assunto = "Relatório"
pyperclip.copy(assunto)
pyautogui.hotkey("ctrl", "v")
pyautogui.press("tab")

texto = f"""
Prezados, bom dia

O faturamento de ontem foi de: {faturamento}
A quatidade de produtos foi de: {quantidade}

Abs
Luiz
"""
pyperclip.copy(texto)
pyautogui.hotkey("ctrl", "v")

pyautogui.click(x=1310, y=1002)

