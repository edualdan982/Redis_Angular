package com.votacion.seq;

import redis.clients.jedis.Jedis;

public class Conexion {
	private Jedis jedis;
	
	public Conexion() {
		this.jedis= new Jedis("localhost",6379);
		
	}

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}
		
}
