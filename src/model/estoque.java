package model;

public class estoque {
private Produto produto;
private int quantidade;
private String tamanho;

public estoque(Produto produto, int quantidade, String tamanho) {
	super();
	this.produto = produto;
	this.quantidade = quantidade;
	this.tamanho = tamanho;
}
public Produto getProduto() {
	return produto;
}
public void setProduto(Produto produto) {
	this.produto = produto;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public String getTamanho() {
	return tamanho;
}
public void setTamanho(String tamanho) {
	this.tamanho = tamanho;
}
}
