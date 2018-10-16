Ext.define('Admin.model.resume.ResumeModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'string',name: 'applicationName'},
		{type: 'string', name: 'expectedPosition'},
		{type: 'string',name: 'idCardNumber'},
		{type: 'string',name: 'idCardPicture'},
		{type: 'date',name: 'birthday',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'gender'},
		{type: 'string', name: 'nation'},
		{type: 'string',name: 'nativePlace'},
		{type: 'string',name: 'registeredAddress'},
		{type: 'string', name: 'houseAddress'},
		{type: 'string',name: 'politicalStatus'},
		{type: 'string',name: 'maritalStatus'},
		{type: 'string', name: 'phoneNumber'},
		{type: 'string', name: 'email'},
		{type: 'string', name: 'qq'},
		{type: 'string', name: 'education'},
		{type: 'string', name: 'major'},
		{type: 'string', name: 'tie'},
		{type: 'string', name: 'graduatedSchool'},
		{type: 'date',name: 'graduatedTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string', name: 'awardsReceived'},
		{type: 'string', name: 'languageLevel'},
		{type: 'string', name: 'workExperience'},
		{type: 'string', name: 'hobbies'},
		{type: 'string', name: 'selfEvaluation'},
		{type: 'string',name: 'state'},
		{type: 'date', name: 'createTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/resume'
	}
});
