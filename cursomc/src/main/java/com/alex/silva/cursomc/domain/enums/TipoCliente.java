package com.alex.silva.cursomc.domain.enums;


/*/
 * Autor: Alex Silva
 * Date:29/08/2019
 * Descrition: Criada method criado para manter o controle do codigo atribuido a cada enumeracao.
 * mail:
 */
public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2," Pessoa Juridica");
	
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod,String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		
	}
	
	public int getCod() {
		return cod;
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		 if(cod==null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido"+cod);
	}
}
