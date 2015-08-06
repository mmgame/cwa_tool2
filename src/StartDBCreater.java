import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import com.cwa.tool.creater.database.Constant;
import com.cwa.tool.creater.database.filecreater.DataBaseFileCreater;
import com.cwa.util.FileUtil;

public class StartDBCreater {
	public static void main(String args[]) {
		String name = "database";
		try {
			DOMConfigurator.configureAndWatch("propertiesconfig/log4j.xml");

			Properties p = getProperties();

			String resourcePath = p.getProperty("resource_path");
			resourcePath = FileUtil.getCurrentParentPath() + FileUtil.separator + resourcePath;
			File rf = new File(resourcePath);
			for (File f : rf.listFiles()) {
				if (!f.isDirectory()) {
					continue;
				}
				String projectName = f.getName();

				File df = new File(f.getPath() + FileUtil.separator + name);
				for (File mf : df.listFiles()) {
					if (!mf.isDirectory()) {
						continue;
					}
					String flag = mf.getName();

					DataBaseFileCreater creater = new DataBaseFileCreater();
					creater.setTemplatesPath(p.getProperty("templates_path"));

					creater.setFlag(flag);
					creater.setProjectName(projectName);

					creater.setCatalogue(p.getProperty("catalogue"));
					creater.setCatalogueStartRow(Integer.parseInt(p.getProperty("catalogue_startrow")));

					creater.setJdbcDriver(p.getProperty(projectName + "_jdbc_driver"));
					creater.setJdbcUrl(p.getProperty(projectName + "_jdbc_url"));
					creater.setJdbcUser(p.getProperty(projectName + "_jdbc_user"));
					creater.setJdbcPassword(p.getProperty(projectName + "_jdbc_password"));
					creater.setTableNumber(p.getProperty(projectName + "_table_number"));
					
					creater.setCreateFilePath(p.getProperty("createfile_path") + File.separator + projectName + File.separator + name
							+ File.separator + flag);
					creater.setResourcePath(p.getProperty("resource_path") + File.separator + projectName + File.separator + name
							+ File.separator + flag);
					Constant constant = new Constant(p.getProperty("project_name"), p.getProperty("createfile_path"));
					constant.init();

					creater.createFile();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Properties getProperties() throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream("propertiesconfig/database.properties"));
		Properties p = new Properties();
		p.load(in);

		// Enumeration e = p.elements();
		// for (; e.hasMoreElements();) {
		// System.out.println(e.nextElement());
		// }
		return p;
	}
}
