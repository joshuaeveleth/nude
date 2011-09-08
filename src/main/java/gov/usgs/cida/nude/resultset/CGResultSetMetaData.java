package gov.usgs.cida.nude.resultset;

import gov.usgs.cida.nude.table.ColumnGrouping;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CGResultSetMetaData implements ResultSetMetaData {
	
	protected final ColumnGrouping cg;
	
	public CGResultSetMetaData(ColumnGrouping columns) {
		this.cg = columns;
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new SQLException("Instance is not unwrappable to interface: " + iface.getName());
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public int getColumnCount() throws SQLException {
		return this.cg.size();
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		return false;
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public boolean isSearchable(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public boolean isCurrency(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public int isNullable(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return ResultSetMetaData.columnNullableUnknown;
	}

	@Override
	public boolean isSigned(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return 20;
	}

	@Override
	public String getColumnLabel(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return this.cg.get(column).getName();
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return this.cg.get(column).getName();
	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return this.cg.get(column).getSchemaName();
	}

	@Override
	public int getPrecision(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return 0;
	}

	@Override
	public int getScale(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return 0;
	}

	@Override
	public String getTableName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return this.cg.get(column).getTableName();
	}

	@Override
	public String getCatalogName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return "";
	}

	@Override
	public int getColumnType(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return java.sql.Types.VARCHAR;
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return "VARCHAR";
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return true;
	}

	@Override
	public boolean isWritable(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return false;
	}

	@Override
	public String getColumnClassName(int column) throws SQLException {
		throwIfInvalidIndex(column);
		return String.class.getCanonicalName();
	}
	
	protected void throwIfInvalidIndex(int column) throws SQLException {
		if (1 > column || column > this.getColumnCount()) {
			throw new SQLException("Invalid column index");
		}
	}
	
}
