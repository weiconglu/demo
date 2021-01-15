package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.SetParams;

public class TxTest {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("192.168.0.120", 6379);

		Transaction transaction = jedis.multi();
		SetParams setParams = new SetParams().ex(10);
		transaction.set("k1", "v1", setParams);
		transaction.set("k2", "v2", setParams);
		transaction.set("k3", "v3", setParams);
		
		transaction.exec();
		
		transaction = null;
		jedis.close();

	}

}
