package jedis;

import redis.clients.jedis.Jedis;

public class PingTest {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("192.168.0.120", 6379);

		System.out.println(jedis.ping());

		jedis.close();

	}

}
