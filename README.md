# Projeto de Servidor TCP e Client 

### 1 - Clonar repositório para maquina local

### 2 - Subir o Servidor TCP

+ Acessar a pasta *tcp-project/java-server-project* pelo cmd ou powershell
+ Rodar comando:
  
  `mvn clean install`
+ Rodar comando:
  
  `mvn exec:java "-Dexec.mainClass=com.personal.tcp.Server"`

### 3 - Subir o Client TCP

+ Acessar a pasta *tcp-project/java-client-project* pelo cmd ou powershell
+ Rodar comando:

  `mvn clean install`
+ Rodar comando:

  `mvn exec:java "-Dexec.mainClass=com.personal.tcp.Client"`

### 4 - Enviar Mensagens
+ No terminal do client, escrever as mensagens no formato Hex e apertar Enter para enviar

### 5 - Verificar banco de dados H2
+ Acessar o link `http://localhost:9092/` pelo browser
+ Clicar em connect
+ Realizar operações nas tabelas:

  USER_INFO
  
  MESSAGES

### 6 - Verificar arquivo de Logs
+ Arquivo `messages.log` é gerado na pasta java-server-project
