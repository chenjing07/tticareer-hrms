Ext.define('Admin.model.employee.EmployeeModel', {
extend: 'Admin.model.Base',
	requires: [
		'Ext.data.proxy.Rest'
	],
	fields: [
		{type: 'int',name: 'id'},
		{type: 'string',name: 'employee_number'},
		{type: 'string', name: 'password'},
		{type: 'string',name: 'real_name'},
		{type: 'string',name: 'id_card_number'},
		{type: 'string', name: 'id_card_picture'},
		{type: 'date',name: 'birthday'},
		{type: 'int',name: 'gender'},
		{type: 'string', name: 'nation'},
		{type: 'string',name: 'native_place'},
		{type: 'string',name: 'registered_address'},
		{type: 'string', name: 'house_address'},
		{type: 'string',name: 'education'},
		{type: 'string',name: 'academic_degree'},
		{type: 'string', name: 'major'},
		{type: 'string',name: 'tie'},
		{type: 'string',name: 'graduated_school'},
		{type: 'date', name: 'graduated_time'},
		{type: 'int',name: 'political_status'},
		{type: 'int',name: 'marital_status'},
		{type: 'int', name: 'recruitment_source'},
		{type: 'string',name: 'account_bank'},
		{type: 'string',name: 'account_number'},
		{type: 'string', name: 'phone_number'},
		{type: 'string',name: 'email'},
		{type: 'string',name: 'qq'},
		{type: 'string', name: 'wechat'},
		{type: 'string',name: 'msn'},
		{type: 'string',name: 'emergency_contact_name'},
		{type: 'string', name: 'emergency_contact_relationship'},
		{type: 'string',name: 'emergency_contact_numbe'},
		{type: 'int',name: 'iswork'},
		{type: 'date', name: 'work_start'},
		{type: 'date',name: 'work_end'},
		{type: 'date',name: 'practice_start'},
		{type: 'date', name: 'practice_end'},
		{type: 'int',name: 'state'},
		{type: 'date',name: 'create_time'},
             {type: 'int', name: 'check_satus'},
    		{type: 'string',name: 'note'}
	],
	proxy: {
		type: 'rest',
		url: '/employee'
	}
});
