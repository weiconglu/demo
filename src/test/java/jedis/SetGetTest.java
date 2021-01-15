package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class SetGetTest {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("192.168.0.120", 6379);

		SetParams setParams = new SetParams().ex(10);
		for (int i = 0; i < 10; i++) {
			jedis.set("k" + i, "v" + i,setParams);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(jedis.get("k"+i));
		}

		setParams = null;
		jedis.close();

	}

}
