# Para limpar os resultados antigos e gerar um novo teste 
mvn clean test

# Para gerar os reportes Allure
allure serve allure-results

# Gerar o relatório HTML
allure generate allure-results --clean -o allure-report
# Abrir o relatório no navegador
allure open allure-report

# Exercício  para quinta feira 

 - cd ./ para acessar o projeto clonado 
 - criar uma branch com o nome do seu usuário
 - Decidir quais testes serão automatizados 
 - Criar novos .features para cada funcionalidade com seus respectivos testes 
