package com.carl.study.ssm.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.carl.study.ssm.model.enums.base.FlagEnum;

/**
 * @desc 
 * @author Carl
 * @create time 2018年5月23日下午10:32:51
 */
public class SexEnumHandler<E extends Enum<E>> extends BaseTypeHandler<FlagEnum>{

	private Class<FlagEnum> type; 
	
	public SexEnumHandler(Class<FlagEnum> type) {
		if(type == null) {
			throw new RuntimeException("type can't is null");
		}
		
		this.type = type;
		
	}
	
	private FlagEnum conver(int flag) {
		FlagEnum[] enums = type.getEnumConstants();
		for (FlagEnum flagEnum : enums) {
			if(flagEnum.getFlagValue() == flag) {
				return flagEnum;
			}
		}
		return null;
	}
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			FlagEnum parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getFlagValue());
		
	}

	@Override
	public FlagEnum getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return conver(rs.getInt(columnName));
	}

	@Override
	public FlagEnum getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return conver(rs.getInt(columnIndex));
	}

	@Override
	public FlagEnum getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return conver(cs.getInt(columnIndex));
	}

}
