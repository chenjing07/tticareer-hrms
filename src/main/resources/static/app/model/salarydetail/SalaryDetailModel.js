Ext.define('Admin.model.salarydetail.SalaryDetailModel', {
    extend: 'Admin.model.Base',
    requires: [
		'Ext.data.proxy.Rest'
	],
    fields: [
    	{type: 'int',name: 'id'},
    	{type:'string',name:'userName'},
    	{type: 'float', name: 'basicSalary'},
    	{type: 'float', name: 'bonus'},
    	{type: 'float',name: 'subsidy'},			
		{type: 'float',name: 'overWorkSalary'},
		{type: 'float', name: 'attendanceDeduction'},
		{type: 'date',name: 'nowYearMonth',dateFormat:'Y/m/d H:i:s'},
		{type: 'date',name: 'createTime',dateFormat:'Y/m/d H:i:s'},
    	{type: 'string',name: 'note'}
    ],
    	proxy: {
		type: 'rest',
		url: '/salarydetail/save'
	}
});