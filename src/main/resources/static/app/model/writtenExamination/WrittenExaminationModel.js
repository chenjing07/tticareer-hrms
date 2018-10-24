Ext.define('Admin.model.writtenExamination.WrittenExaminationModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'resumeId'},
		{type: 'int', name: 'examContentId'},
		{type: 'date', name: 'examStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'},	
		{type: 'int',name: 'examScore'},
		{type: 'int',name: 'examResult'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'date', name: 'examEnd',dateFormat:'Y/m/d H:i:s'}
		
	],
	proxy: {
		type: 'rest',
		url: '/writtenexamination/save'
	}
});
