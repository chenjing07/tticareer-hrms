Ext.define('Admin.view.authentication.RealNameWindow', {
    extend: 'Admin.view.authentication.LockingWindow',
    alias: 'widget.realNameWindow',

    requires: [
	'Admin.view.authentication.Dialog',
	'Ext.button.Button',
	'Ext.form.Label',
	'Ext.form.field.Checkbox',
	'Ext.form.field.Text'
    ],
   
    title: 'Real Name Authentication Window',
    defaultFocus: 'authdialog', 
    
    items: [{
        xtype: 'authdialog',
        bodyPadding: '20 20',
        width: 455,
        reference : 'authDialog',
        defaultButton : 'realNameAuthenticationSubmitButton',
        autoComplete: true,
        layout: {
                type: 'vbox',
                align: 'stretch'
            },
        defaults : {
                margin: '10 0',
                selectOnFocus : true
            },
        items: [{
            xtype: 'label',
            cls: 'lock-screen-top-label',
            text: 'Real Name Authentication'
         }, {
            xtype: 'textfield',
            hideLabel: true,
            emptyText: 'Real Name',
		name: 'realName',
		bind: '{realName}',
		height: 55,
		allowBlank : false
        }, {
            xtype: 'textfield',
            hideLabel: true,
            emptyText: 'id Card Number',
            name:'idCardNumber',
            bind: '{idCardNumber}',
		height: 55,
		allowBlank : false
        }, {
            xtype: 'filefield',
            hideLabel: true,
            emptyText: 'id Card Picture',
            name:'idCardPicture',
            bind: '{idCardPicture}',
		allowBlank : false,
		buttonConfig: {
	            xtype: 'filebutton',
	            glyph:'',
	            text: 'Browse'
	        }
        },{
        	xtype: 'button',
        	scale: 'large',
             ui: 'soft-green',
             formBind: true,
             reference: 'realNameAuthenticationSubmitButton',
             bind: false,
             margin: '5 0',
             iconAlign: 'right',
             iconCls: 'x-fa fa-angle-right',
        	text: 'Submit',
       	listeners: {
                   click: 'realNameAuthenticationSubmitButton'
             }
	},{
        	xtype: 'button',
             scale: 'large',
             ui: 'soft-green',
             margin: '5 0',
        	text: 'Close',
        	handler: function(button) {
            button.up('window').close();
        }
	}]
    }]
});
