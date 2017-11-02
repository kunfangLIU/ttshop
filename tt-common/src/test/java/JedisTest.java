import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * User: DHC
 * Date: 2017/10/31
 * Time: 14:21
 * Version:V1.0
 */
public class JedisTest {

    @Test
    public void testJedis1(){
        Jedis jedis = new Jedis("10.31.166.22",6379);
        jedis.set("name","dhc");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
    @Test
    public void testJedis2(){
        //获取一个jedis池
        JedisPool jedisPool = new JedisPool("10.31.166.22", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("name1","dhc");
        System.out.println(jedis.get("name1"));
        jedis.close();
        jedisPool.close();
    }

   /* @Test
    public void testJedis3(){
        //创建集群节点集合
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        //将6个节点加入到集合中
        nodes.add(new HostAndPort("10.31.166.46",8001));
        nodes.add(new HostAndPort("10.31.166.46",8002));
        nodes.add(new HostAndPort("10.31.166.46",8003));
        nodes.add(new HostAndPort("10.31.166.46",8004));
        nodes.add(new HostAndPort("10.31.166.46",8005));
        nodes.add(new HostAndPort("10.31.166.46",8006));
        //创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //存入数据
        jedisCluster.set("key2","value2");
        System.out.println(jedisCluster.get("key2"));
        //关闭连接
        jedisCluster.close();
    }*/
}
