Ext.define('Admin.model.attendance.OverWorkModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
	    {type: 'int',name: 'id'},
	    {type: 'int',name: 'employeeId'},
	    {type: 'string',name: 'userName'},
	    {type: 'string',name: 'realName'},
	    {type: 'date', name: 'time', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'duration'},
	    {type: 'string',name: 'content'},
	    {type: 'date', name: 'createTime', dateFormat:'Y/m/d H:i:s'},
	    {type: 'string',name: 'note'},
	],
	proxy: {
		type: 'rest',
		url: '/attendance/owsave',
	}
});