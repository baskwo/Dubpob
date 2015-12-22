package org.dubpob.orm.sql;

import static com.googlecode.cqengine.query.QueryFactory.equal;

import org.dubpob.orm.pojo.EntityModel;
import org.dubpob.orm.sql.impl.DAOImpl;

import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.index.unique.UniqueIndex;
import com.googlecode.cqengine.resultset.ResultSet;


@SuppressWarnings("rawtypes")
public class DAOFactory {
	private IndexedCollection<DAOImpl> daos = CQEngine.newInstance();
	private ConnectionManager manager;
	
	public DAOFactory(ConnectionManager manager) {
		daos.addIndex(UniqueIndex.onAttribute(DAOImpl.DAO_ENTITY));
		this.manager = manager;
	}
	
	public <T extends Packable & Unpackable> DAOImpl getDAO(EntityModel model) {
		DAOImpl dao = null;
		ResultSet<DAOImpl> rs = daos.retrieve(equal(DAOImpl.DAO_ENTITY,model.getEntity().getCanonicalName()));
		if(rs != null && rs.isNotEmpty()) {
			dao = rs.uniqueResult();
		} else {
			dao = new DAOImpl<T>(manager.getConnection(), model.getTable(), model);
			daos.add(dao);
		}
		return dao;
	}
}
