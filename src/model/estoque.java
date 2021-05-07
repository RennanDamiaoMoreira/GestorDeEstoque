package model;

public class Estoque {
private Produto produto;
private int quantidade;
private Tamanho tamanho;

public Estoque(Produto produto, int quantidade, Tamanho tamanho) {
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
public Tamanho getTamanho() {
	return tamanho;
}
public void setTamanho(Tamanho tamanho) {
	this.tamanho = tamanho;
}

}
