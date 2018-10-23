Ext.define('Admin.model.archives.ArchivesModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'employeeId'},
		{type: 'date',name: 'inTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'outTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string', name: 'archivesSource'},
		{type: 'string',name: 'archivesDestination'},
		{type: 'string',name: 'archivesChange'},
		{type: 'int',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
             {type: 'int', name: 'checkStatus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/archives/save'
	}
});
