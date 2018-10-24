Ext.define('Admin.model.attendance.LeaveDetailModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'userName'},
	    {type: 'string',name: 'realName'},
	    {type: 'date', name: 'leaveStart', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'leaveEnd', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'leaveDays'},
	    {type: 'string',name: 'reason'},
	    {type: 'date', name: 'realStart', dateFormat:'Y/m/d H:i:s'},
	    {type: 'date', name: 'realEnd', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'state'},
	    {type: 'string',name: 'checkStatus'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/attendance/ldsave',
	}
});