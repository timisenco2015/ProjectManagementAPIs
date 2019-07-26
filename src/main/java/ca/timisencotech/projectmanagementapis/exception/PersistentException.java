package ca.timisencotech.projectmanagementapis.exception;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.CannotSerializeTransactionException;
import org.springframework.dao.CleanupFailureDataAccessException;
	import org.springframework.dao.DataAccessException;
	import org.springframework.dao.DeadlockLoserDataAccessException;
	import org.springframework.dao.DuplicateKeyException;
	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
	import org.springframework.dao.InvalidDataAccessApiUsageException;
	import org.springframework.dao.PermissionDeniedDataAccessException;
	import org.springframework.dao.QueryTimeoutException;
	import org.springframework.dao.RecoverableDataAccessException;
	import org.springframework.dao.TransientDataAccessResourceException;
	import org.springframework.dao.TypeMismatchDataAccessException;
	import org.springframework.jca.cci.CannotCreateRecordException;
	import org.springframework.jca.cci.CannotGetCciConnectionException;
	import org.springframework.jca.cci.CciOperationNotSupportedException;
	import org.springframework.jca.cci.InvalidResultSetAccessException;
	import org.springframework.jca.cci.RecordTypeNotSupportedException;
	import org.springframework.jdbc.BadSqlGrammarException;
	import org.springframework.jdbc.CannotGetJdbcConnectionException;
	import org.springframework.jdbc.IncorrectResultSetColumnCountException;
	import org.springframework.jdbc.LobRetrievalFailureException;
	import org.springframework.jdbc.SQLWarningException;
	import org.springframework.jdbc.UncategorizedSQLException;
	import org.springframework.jdbc.datasource.init.ScriptParseException;
	import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
	import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
	import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
	import org.springframework.jdbc.support.xml.SqlXmlFeatureNotImplementedException;
	import org.springframework.orm.hibernate5.HibernateJdbcException;
	import org.springframework.orm.hibernate5.HibernateObjectRetrievalFailureException;
	import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
	import org.springframework.orm.hibernate5.HibernateQueryException;
	import org.springframework.orm.hibernate5.HibernateSystemException;
	import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
	import org.springframework.orm.jpa.JpaOptimisticLockingFailureException;
	import org.springframework.orm.jpa.JpaSystemException;
	
	public class PersistentException {
	

		
		
		
	public PersistentException() {
			
		}

	public ApiError	handleDataAccessException(DataAccessException dataAccessException)  {
			if (dataAccessException instanceof CannotAcquireLockException) {
				return new ApiError("Persistence Error", "");
			}
			else if (dataAccessException instanceof RecoverableDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof ScriptParseException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof ScriptStatementFailedException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof UncategorizedScriptException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof HibernateOptimisticLockingFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof CannotAcquireLockException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CannotSerializeTransactionException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CleanupFailureDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CannotAcquireLockException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof DeadlockLoserDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof JpaOptimisticLockingFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof QueryTimeoutException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof TransientDataAccessResourceException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof DuplicateKeyException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof IncorrectResultSetColumnCountException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof EmptyResultDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof LobRetrievalFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof HibernateObjectRetrievalFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof JpaObjectRetrievalFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof DataSourceLookupFailureException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof InvalidDataAccessApiUsageException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof BadSqlGrammarException) {
				return new ApiError("Persistence Error", "");
			}
			else if (dataAccessException instanceof CciOperationNotSupportedException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof HibernateQueryException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof IncorrectUpdateSemanticsDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof InvalidResultSetAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof RecordTypeNotSupportedException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof TypeMismatchDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CannotCreateRecordException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CannotGetCciConnectionException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof CannotGetJdbcConnectionException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof PermissionDeniedDataAccessException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof HibernateJdbcException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof HibernateSystemException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof JpaSystemException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof SQLWarningException) {
				return new ApiError("Persistence Error", "");
			}
			
			
			else if (dataAccessException instanceof UncategorizedSQLException) {
				return new ApiError("Persistence Error", "");
			}
			
			else if (dataAccessException instanceof SqlXmlFeatureNotImplementedException) {
				return new ApiError("Persistence Error", "");
			}
			
			else 
			{
				if(dataAccessException.getCause().getClass().getSimpleName().equalsIgnoreCase("ConstraintViolationException"))
				{
					return new ApiError("Persistence Error", "Constraint error");
				}
				else
				{
					return new ApiError("Persistence Error", "Not a known error");
					
				}
			}
		}
		

	
	public ApiError	handleSearchReturnNull(String message) 
	{
		return new ApiError("Persistence Error", message);
	}
		
	
	}
