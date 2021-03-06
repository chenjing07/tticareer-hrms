Ext.define('Admin.model.employee.EmployeeModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'string',name: 'userName'},
		{type: 'string', name: 'password'},
		{type: 'string',name: 'realName'},
		{type: 'string',name: 'idCardNumber'},
		{type: 'string', name: 'idCardPicture'},
		{type: 'date',name: 'birthday',dateFormat:'Y/m/d H:i:s'},
		{type: 'int',name: 'gender'},
		{type: 'string', name: 'nation'},
		{type: 'string',name: 'nativePlace'},
		{type: 'string',name: 'registeredAddress'},
		{type: 'string', name: 'houseAddress'},
		{type: 'string',name: 'education'},
		{type: 'string',name: 'academicDegree'},
		{type: 'string', name: 'major'},
		{type: 'string',name: 'tie'},
		{type: 'string',name: 'graduatedSchool'},
		{type: 'date', name: 'graduatedTime',dateFormat:'Y/m/d H:i:s'},
		{type: 'int',name: 'politicalStatus'},
		{type: 'int',name: 'maritalStatus'},
		{type: 'int', name: 'recruitmentSource'},
		{type: 'string',name: 'accountBank'},
		{type: 'string',name: 'accountNumber'},
		{type: 'string', name: 'phoneNumber'},
		{type: 'string',name: 'email'},
		{type: 'string',name: 'qq'},
		{type: 'string', name: 'wechat'},
		{type: 'string',name: 'msn'},
		{type: 'string',name: 'emergencyContactName'},
		{type: 'string', name: 'emergencyContactRelationship'},
		{type: 'string',name: 'emergencyContactNumber'},
		{type: 'int',name: 'iswork'},
		{type: 'date', name: 'workStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'workEnd',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'practiceStart',dateFormat:'Y/m/d H:i:s'},
		{type: 'date', name: 'practiceEnd',dateFormat:'Y/m/d H:i:s'},
		{type: 'int',name: 'state'},
		{type: 'date',name: 'createTime',dateFormat:'Y/m/d H:i:s'},
             {type: 'int', name: 'checkSatus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/employee/save'
	}
});
