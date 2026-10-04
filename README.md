Before running, install the middleware and associated tools (on both machines):


## On Amazon Linux
```
sudo dnf install https://download.zeroc.com/ice/3.7/amzn2023/ice-repo-3.7.amzn2023.noarch.rpm
```

```
sudo dnf install python3-ice ice-compilers
```

## On Ubuntu
```
wget "https://download.zeroc.com/ice/3.8/ubuntu26.04/ice-repo-3.8_1.0.0_all.deb" -O ice-repo.deb
sudo dpkg -i ice-repo.deb
rm ice-repo.deb
sudo apt-get update
```
```
sudo apt-get install python3-zeroc-ice
```
```
sudo apt-get install zeroc-ice-compilers
```
Note: This code is exactly as in Example 3.21 of Maarten van Steen's book.

## Compilando e Executando a Versão Java

Primeiro, você precisará compilar a interface Ice para Java e depois compilar os arquivos Java (os comandos dependem do seu ambiente, mas em geral são):
```bash
# Gerando a interface Java a partir do arquivo .ice
slice2java Printer.ice

# Compilando os arquivos Java (assumindo que o ice.jar está no classpath)
javac Demo/*.java java/*.java
```

### Cenário 1: Cliente Python e Servidor Java
1. Inicie o servidor Java:
```bash
java java.Server
```
2. Em outro terminal, execute o cliente Python:
```bash
python3 client.py
```

### Cenário 2: Cliente Java e Servidor Python
1. Inicie o servidor Python:
```bash
python3 server.py
```
2. Em outro terminal, execute o cliente Java:
```bash
java java.Client
```
*(Nota: Certifique-se de que os IPs nos clientes correspondem ao servidor onde estão sendo executados).*

---
