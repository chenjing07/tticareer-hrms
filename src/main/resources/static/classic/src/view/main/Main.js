Ext.define('Admin.view.main.Main', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.button.Segmented',
        'Ext.list.Tree',
        'Ext.form.field.ComboBox'
    ],

    controller: 'main',
    viewModel: 'main',

    cls: 'sencha-dash-viewport',
    itemId: 'mainView',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    listeners: {
        render: 'onMainViewRender'
    },

    items: [
        {
            xtype: 'toolbar',
            cls: 'sencha-dash-dash-headerbar shadow',
            height: 64,
            itemId: 'headerBar',
            items: [
                {
                    xtype: 'component',
                    reference: 'senchaLogo',
                    cls: 'sencha-logo',
                    html: '<div class="main-logo"><img src="resources/images/company-logo.png">TTI 创科集团</div>',
                    width: 250
                },
                {
                    margin: '0 0 0 8',
                    ui: 'header',
                    iconCls:'x-fa fa-navicon',
                    id: 'main-navigation-btn',
                    handler: 'onToggleNavigationSize'
                },
                '->',
                {
                    xtype: 'tbtext',
                    /*返回登录名*/
                    text:'用户名：Admin',
                    id:'UserName',
                    cls: 'top-user-name'
                },{
                    xtype: 'image',
                    cls: 'header-right-profile-image',
                    id:'loginUserImage',
                    height: 35,
                    width: 35,
                    alt:'current user image',
                    src: 'resources/images/user-profile/2.png'/*点击可以弹出更换照片*/
	         },{    	 
	         	   ui: 'header',
	                iconCls:'x-fa fa-navicon',
	                menu:{
	                	items:[
	                	{
	                		xtype:'button',
	                		buttonAlign:'left',
	                		hideLabel: true,
	                		text:'修改个人信息',
	                		handler:function(btn){
	                			btn.up('container').up('container').up('container').add(Ext.widget('modifyInformationWindow')).show();
	                		}
	                	},
	                	{
	                		xtype:'button',
	                		buttonAlign:'left',
	                		hideLabel: true,
	                	      text:'修改个人密码',
	                	      handler:function(btn){
	                			btn.up('container').up('container').up('container').add(Ext.widget('modifyPasswordWindow')).show();
	                		}
	                   }
	                ]}
	         },{
                    iconCls:'x-fa fa-sign-out',
                    ui: 'header',
                    tooltip: 'Logout',
                    handler: 'logoutButton'
                }
            ]
        },
        {
            xtype: 'maincontainerwrap',
            id: 'main-view-detail-wrap',
            reference: 'mainContainerWrap',
            flex: 1,
            items: [
                {
                    xtype: 'treelist',
                    reference: 'navigationTreeList',
                    itemId: 'navigationTreeList',
                    ui: 'nav',
                    store: 'NavigationTree',
                    width: 250,
                    expanderFirst: false,
                    expanderOnly: false,
                    listeners: {
                        selectionchange: 'onNavigationTreeSelectionChange'
                    }
                },
                {
                    xtype: 'container',
                    flex: 1,
                    reference: 'mainCardPanel',
                    cls: 'sencha-dash-right-main-container',
                    itemId: 'contentPanel',
                    layout: {
                        type: 'card',
                        anchor: '100%'
                    }
                }
            ]
        }
    ]
});
