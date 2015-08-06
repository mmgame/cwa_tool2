package com.cwa.tool.creater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cwa.tool.component.IStructure;
import com.cwa.util.FileUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class AbstractFileCreater implements IFileCreater {
	protected static final Logger logger = LoggerFactory.getLogger(IFileCreater.class);

	protected String templatesPath;// 模板路径
	protected String resourcePath;// 资源路径
	protected String createFilePath;// 生成文件路径

	protected void createFile(ITemplatePrepare prepare, IStructure structure) {
		Writer out = null;
		try {
			Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File(templatesPath));

			cfg.setObjectWrapper(new DefaultObjectWrapper());

			Template temp = cfg.getTemplate(prepare.getFtlFilePath(structure));
			Map<String, Object> root = prepare.createMap(structure);
			if (root == null || root.isEmpty()) {
				return;
			}
			File file = prepare.getFile(structure);
			OutputStream outputStream = new FileOutputStream(file);
			out = new OutputStreamWriter(outputStream);
			temp.process(root, out);
			out.flush();
		} catch (Exception e) {
			logger.error("", e);
			throw new RuntimeException(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			prepare.createEnd(structure);
		}
	}

	public void setCreateFilePath(String createFilePath) {
		this.createFilePath = FileUtil.getCurrentParentPath() + FileUtil.separator + createFilePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = FileUtil.getCurrentParentPath() + FileUtil.separator + resourcePath;
	}

	public void setTemplatesPath(String templatesPath) {
		this.templatesPath = FileUtil.getCurrentParentPath() + FileUtil.separator + templatesPath;
	}

	public String getTemplatesPath() {
		return templatesPath;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public String getCreateFilePath() {
		return createFilePath;
	}
}
