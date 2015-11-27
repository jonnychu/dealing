package com.example.dealingapp.mvc.plugin.table;

import javax.swing.table.TableColumn;

public class GTableColumn extends TableColumn {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ColumnProperty columnProperty;

	public GTableColumn(String groupId, String columnId, String columnName, String setterMethod,
			String getterMethod, Class<?> columnClazz, int colWidth, boolean isFixed,Class<?> rowClazz) {
		columnProperty = new ColumnProperty(groupId, columnId, columnName, setterMethod, getterMethod, columnClazz, colWidth,
				isFixed,rowClazz);
	}

	public ColumnProperty getColumnProperty() {
		return columnProperty;
	}

	public void setColumnProperty(ColumnProperty columnProperty) {
		this.columnProperty = columnProperty;
	}
	
	public class ColumnProperty {
		
		private String colGroupId;
		private int colHeight = 22;
		private Class<?> columnClazz;
		private String columnId;
		private String columnName;
		private int colWidth = 100;
		private String getterMethod;
		private Class<?> rowClazz;
		private String setterMethod;
		private boolean isFixed;

		public ColumnProperty(String groupId, String columnId, String columnName, String setterMethod, 
				String getterMethod, Class<?> columnClazz, int width, boolean isFixed,Class<?> clazz) {
			this.colGroupId = groupId;
			this.columnId = columnId;
			this.columnName = columnName;
			this.setterMethod = setterMethod;
			this.columnClazz = columnClazz;
			this.getterMethod = getterMethod;
			this.colWidth = width;
			this.isFixed = isFixed;
			this.rowClazz = clazz;
		}

		public String getColGroupId() {
			return colGroupId;
		}

		public int getColHeight() {
			return colHeight;
		}

		public Class<?> getColumnClazz() {
			return columnClazz;
		}

		public String getColumnId() {
			return columnId;
		}

		public String getColumnName() {
			return columnName;
		}

		public int getColWidth() {
			return colWidth;
		}

		public String getGetterMethod() {
			return getterMethod;
		}

		public Class<?> getRowClazz() {
			return rowClazz;
		}

		public String getSetterMethod() {
			return setterMethod;
		}

		public void setColGroupId(String colGroupId) {
			this.colGroupId = colGroupId;
		}

		public void setColHeight(int colHeight) {
			this.colHeight = colHeight;
		}

		public void setColumnClazz(Class<?> columnClazz) {
			this.columnClazz = columnClazz;
		}

		public void setColumnId(String columnId) {
			this.columnId = columnId;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public void setColWidth(int colWidth) {
			this.colWidth = colWidth;
		}

		public void setGetterMethod(String getterMethod) {
			this.getterMethod = getterMethod;
		}

		public void setRowClazz(Class<?> rowClazz) {
			this.rowClazz = rowClazz;
		}

		public void setSetterMethod(String setterMethod) {
			this.setterMethod = setterMethod;
		}

		public boolean isFixed() {
			return isFixed;
		}

		public void setFixed(boolean isFixed) {
			this.isFixed = isFixed;
		}
	}
}
