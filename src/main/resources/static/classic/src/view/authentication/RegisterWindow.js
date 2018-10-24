Ext.define('Admin.view.authentication.RegisterWindow', {
    extend: 'Admin.view.authentication.LockingWindow',
    xtype: 'registerWindow',

    requires: [
        'Admin.view.authentication.Dialog',
        'Ext.button.Button',
        'Ext.form.field.ComboBox',
        'Ext.form.Label',
        'Ext.form.field.Checkbox',
        'Ext.form.field.Text'
    ],

    title: 'User Registration',
    defaultFocus: 'authdialog',  // Focus the Auth Form to force field focus as well

    items: [
        {
            xtype: 'authdialog',
            bodyPadding: '20 20',
            width: 455,
            reference : 'authDialog',

            defaultButton : 'registerButton',
            autoComplete: true,
            cls: 'auth-dialog-register',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            defaults : {
                margin: '10 0',
                selectOnFocus : true
            },
            items: [
                {
                    xtype: 'label',
                    cls: 'lock-screen-top-label',
                    text: 'Create an account'
                },
                {
                    xtype: 'textfield',
                    cls: 'auth-textbox',
                    height: 55,
                    hideLabel: true,
                    allowBlank : false,
                    emptyText: 'UserName',
                    name: 'userName',
                    id: 'userName',
                    bind: '{userName}',     
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-email-trigger'
                        }
                    }
                },
                {
                    xtype: 'textfield',
                    cls: 'auth-textbox',
                    height: 55,
                    hideLabel: true,
                    allowBlank : false,
                    inputType: 'password',
                    id:'password',
                    name: 'password',
                    bind: '{password}',
                    emptyText: 'Password',
                    vtype:'alphanum',     
			 regex: /^([a-zA-Z0-9]{6,16})$/,
			 regexText: '密码必须同时包含字母和数字,且最少有6位,最多为16位',
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-password-trigger'
                        }
                    }
                },
                {
                    xtype: 'textfield',
                    cls: 'auth-textbox',
                    height: 55,
                    hideLabel: true,
                    allowBlank : false,
                    inputType: 'password',
                    vtype: 'password',
                    name: 'conform_password',  
                    emptyText: 'ConformPassword',  
                    initialPassField:'password',
                    handler:Ext.apply(Ext.form.VTypes, {
	                   	password : function(val, field) {
	                    		if (field.initialPassField) {
	                        			var pwd = Ext.getCmp(field.initialPassField);
	                        			return (val == pwd.getValue());
	                    		}
	                    		return true;
	                		},
	                		passwordText : '两次输入的密码不一致!'
            	}),
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-password-trigger'
                        }
                    }
                }, 
                {
                    xtype: 'combobox',
                    //cls: 'auth-textbox',
                    reference:'selectFieldName',
                    height: 55,
                    hideLabel: true,
                    allowBlank : false, 
                    triggers: {
                        glyphed: {
                            cls: 'trigger-glyph-noop auth-email-trigger'
                        }
                    },
                    store:Ext.create("Ext.data.Store", {
				    fields: ["name", "value"],
				    data: [
				      	{ name: '人事部普通员工', value: '2' },
						{ name: '人事部经理', value: '3' }
				    ]
				}),
	            displayField: 'name',
	            valueField:'value',
	            //value:'2',
	            selectOnFocus:false,
	            editable: false,
	            queryMode: 'local',
	            //triggerAction: 'all',
	            emptyText: 'Select a state'
		      /*listeners:{
				select: 'searchComboboxSelectChuang'
	      	}*/
                },
                {
                    xtype: 'button',
                    scale: 'large',
                    ui: 'soft-green',
                    formBind: true,
                    reference: 'registerSubmitButton',
                    bind: false,
                    margin: '5 0',
                    iconAlign: 'right',
                    iconCls: 'x-fa fa-angle-right',
                    text: 'submit',
                    listeners: {
                        click: 'registerSubmitButton'
                    }
                }
            ]
        }
    ]
});
