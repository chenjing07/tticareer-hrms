Ext.define('Admin.model.writtenExaminationContent.WrittenExaminationContentModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'int',name: 'oneId'},
		{type: 'int', name: 'twoId'},
		{type: 'int',name: 'threeId'},
		{type: 'int',name: 'fourId'},
		{type: 'int',name: 'fiveId'},
		{type: 'int', name: 'sixId'},
		{type: 'int',name: 'sevenId'},
		{type: 'int',name: 'eightId'},
		{type: 'int', name: 'nineId'},
		{type: 'int',name: 'tenId'},
		{type: 'string',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/writtenexaminationcontent/save'
	}
});
