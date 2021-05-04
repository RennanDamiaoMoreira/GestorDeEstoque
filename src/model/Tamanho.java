package model;

public class Tamanho {
private String nome;
private int id;
public Tamanho(String nome) {
	super();
	this.nome = nome;
}
public Tamanho(String nome, int id) {
	super();
	this.nome = nome;
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getId() {
	return id;
}
}
