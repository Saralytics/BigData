package demo;

import org.junit.Test;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;


public class TestHBase {
	
	// HBase doesn't operate via JDBC, it is object oriented 
	// Java program is a client -> Client first talk to zookeeper 
	
	// IMPORTANT NOTE: here the client (this program) is issued from our laptop, then the client gets the host for master
	// back from zookeeper, but zookeeper returns host name, not host IP. 
	// So on this machine, we need to also configure /etc/hosts
	
	// create a table 
	@Test
	public void testCreateTable() throws Exception{
		// configure zookeeper location (refer to notes when configuring HBase on Linux machines)

		Configuration config = new Configuration();
		config.set("hbase.zookeeper.quorum", "192.168.143.112"); 
		
		// create the client 
		@SuppressWarnings("deprecation")
		HBaseAdmin admin = new HBaseAdmin(config);
		
		// 
		HTableDescriptor htd = new HTableDescriptor(TableName.valueOf("mystudent"));
		htd.addFamily(new HColumnDescriptor("info"));
		htd.addFamily(new HColumnDescriptor("grade"));
	
		admin.createTable(htd);
		System.out.println("I created table");
		
		admin.close();
		
	}
	
	// insert 1 row of data 
	
	@Test
	public void testPut() throws Exception {
		// configure zookeeper location (refer to notes when configuring HBase on Linux machines)

		Configuration config = new Configuration();
		config.set("hbase.zookeeper.quorum", "192.168.143.112"); 
		
		// Get the client of hbase table
		@SuppressWarnings("deprecation")
		HTable table = new HTable(config,"mystudent");
		
		// Prep the data to insert 
		Put put = new Put(Bytes.toBytes("s001")); // the rowkey
		
		put.addColumn(Bytes.toBytes("info"),        //family: column family
						Bytes.toBytes("name"),		// column name 
						Bytes.toBytes("Zhaoxue Li") // value
						);
		
		table.put(put);
		table.close();
	}
	
	
	// insert multiple rows 
	// talbe.put(List<put>)
	
	// Run Get command 
	@Test
	public void testGet() throws Exception {
		// configure zookeeper location (refer to notes when configuring HBase on Linux machines)

		Configuration config = new Configuration();
		config.set("hbase.zookeeper.quorum", "192.168.143.112"); 
		
		// Get the client of hbase table
		@SuppressWarnings("deprecation")
		HTable table = new HTable(config,"mystudent");
		
		// Get using rowkey 
		Get get = new Get(Bytes.toBytes("s001"));
		
		Result r = table.get(get);
		String name = Bytes.toString(r.getValue(Bytes.toBytes("info"), Bytes.toBytes("name")));
		System.out.println(name);
		
		
		table.close();
	}
	
	// run Scan command
	
	

}
