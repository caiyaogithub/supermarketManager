package util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @description Xml文件操作
 *
 * @author hello world
 *
 * @modifyTime 2015年9月1日
 */
public class XmlUtils {
	/**
	 * 从web-inf/config/'fileName'中读取标签名为key的值。
	 * @param key 标签名
	 * @param fileName Xml文件名
	 * @return 标签值
	 */
	public static String getValue(String key , String fileName ){
		try {
			Document doc = getDocumentFromXml(Constrant.SERVER_PATH + "WEB-INF/config/" + fileName ) ;
			String value = doc
					.getElementsByTagName(key).item(0)
					.getFirstChild().getNodeValue() ;
			return value ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" ;
	}
	/**
	 * 
	 * @param xmlPath
	 *            xml文件的位置
	 * @return 这个xml文件相应的Document对象
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private static Document getDocumentFromXml(String xmlPath)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlPath);
		return doc;
	}
	private static class Test{
		public static void main(String[] args) {
			System.out.println(XmlUtils.getValue("connection-driver", "config.xml")) ;
		}
	}
}
