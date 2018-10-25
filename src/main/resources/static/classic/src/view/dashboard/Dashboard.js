Ext.define('Admin.view.dashboard.Dashboard', {
    extend: 'Ext.container.Container',
    xtype: 'admindashboard',

    requires: [
        'Ext.ux.layout.ResponsiveColumn'
    ],

    controller: 'dashboard',
    viewModel: {
        type: 'dashboard'
    },

    layout: 'responsivecolumn',
//    
//    listeners: {
//        hide: 'onHideView'
//    },
	html:'<div style="width:100%;height:100%;text-align:center;margin:0 auto;" >'+
	'<img src="resources/images/img1.jpg" style="width:1650px;height:820px; filter: blur(3px);-webkit-filter: blur(6px); -ms-filter: blur(6px);-moz-filter: blur(6px);vertical-align:middle;"/>'+
	'<h1 style="font-size:30px;margin-bottom:0px;">TTi 创科人事管理系统</h1></div>'
	//items: []
});
