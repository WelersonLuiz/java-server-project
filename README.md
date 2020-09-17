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

### 7 - Exemplos

| Cenário                         | Valor                                                             |
|---------------------------------|-------------------------------------------------------------------|
| Mensagem com Texto              | 0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 DC 0D                   |
| Mensagem com User Info          | 0A 15 A2 20 7A C3 0C 4D 69 63 68 65 6C 20 52 65 69 70 73 16 0D    |
| Mensagem com Timezone           | 0A 16 A3 41 6D 65 72 69 63 61 2F 53 61 6F 5F 50 61 75 6C 6F CD 0D |
| Mensagem com Timezone Inválida  | 0A 16 A3 41 6D 65 72 69 63 61 2F 53 61 6F 5F 50 61 75 6C 6D C3 0D |
| Mensagem com Frame Inválido     | 0A 10 A0 48 65 6C 6C 6F 20 57 6F 72 6C 64 81 0D                   |
| Mensagem com CRC inválido       | 0A 10 A1 48 65 6C 6C 6F 20 57 6F 72 6C 64 00 0D                   |
| Mensagem com Formato inválido   | Teste                                                             |
