package com.votacion.seq;

public class Secuencia {

	private Conexion redis = new Conexion();
	private final static String KEY="seq_res";
	private final static String KEY_PRG="seq_pregunta";
	
	public void setSeqRespuesta() {
		String temp = redis.getJedis().get(KEY);
		Integer i = Integer.parseInt(temp);
		i++;
		redis.getJedis().set(KEY,i.toString());
	}
	
	public String setSeqPregunta() {
		String temp = redis.getJedis().get(KEY_PRG);
		Integer i = Integer.parseInt(temp);
		i++;
		redis.getJedis().set(KEY_PRG,i.toString());
		return i.toString();
	}
}
