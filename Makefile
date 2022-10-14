compile: 
	clear
	rm -f */*.class
	mkdir -p Vet/obj
	mkdir -p Server/obj
	mkdir -p Client/obj
	javac -d Vet/obj/ -cp Vet/obj Vet/*.java
	javac -d Server/obj/ -cp Vet/obj Server/*.java
	javac -d Client/obj/ -cp Vet/obj Client/*.java
server:
	clear
	java -cp "Server/obj:Vet/obj" Server.Server

client:
	clear
	java -cp "Client/obj:Vet/obj" Client.Main