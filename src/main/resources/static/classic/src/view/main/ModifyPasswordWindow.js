Ext.define('Admin.view.authentication.ModifyPasswordWindow', {
   extend: 'Ext.window.Window',
    xtype: 'modifyPasswordWindow',

    requires: [
        'Admin.view.authentication.Dialog',
        'Ext.button.Button',
        'Ext.form.field.ComboBox',
        'Ext.form.Label',
        'Ext.form.field.Checkbox',
        'Ext.form.field.Text'
    ],

    height: 300,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    closable: true,
    constrain: true,
    title: 'Modify Password Window',
    defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
          xtype:'form',
          layout: 'form',
          padding: '10px',
          ariaLabel: 'Modify Your Password',
          items: [
              {
	                xtype: 'textfield',
	                fieldLabel: 'User Name',
	                allowBlank : false,
	                name:'userName',
	                hidden: true,
	                readOnly: true
              },{
	                xtype: 'textfield',
	                fieldLabel: 'Old Password',
	                allowBlank : false,
	                name:'password',
	                inputType: 'password',
	                vtype:'alphanum',     
			   regex: /^([a-zA-Z0-9]{6,16})$/,
			   regexText: '密码必须同时包含字母和数字,且最少有6位,最多为16位'
              },
              {
                      xtype: 'textfield',
                      fieldLabel: 'New Password',
                      allowBlank : false,
            	   name:'newPassword',
            	   id:'newPassword',
            	   inputType: 'password',
            	   vtype:'alphanum',     
			   regex: /^([a-zA-Z0-9]{6,16})$/,
			   regexText: '密码必须同时包含字母和数字,且最少有6位,最多为16位'
              },
              {
                      xtype: 'textfield',
                      fieldLabel: 'Conform New Password',
                      allowBlank : false,
            	   name:'conformNewPassword',
            	   inputType: 'password',
            	   vtype: 'password',    
			   initialPassField:'newPassword',
			   handler:Ext.apply(Ext.form.VTypes, {
	                   	password : function(val, field) {
	                    		if (field.initialPassField) {
	                        			var pwd = Ext.getCmp(field.initialPassField);
	                        			return (val == pwd.getValue());
	                    		}
	                    		return true;
	                		},
	                		passwordText : '两次输入的密码不一致!'
            	})
              }
              ]
         }],
		buttons:['->',{
			xtype: 'button',
			text: 'submit',
			handler: 'modifyPasswordSubmitButton'
		},{
			xtype: 'button',
			text: 'Close',
			handler: function(btn) {
				btn.up('window').close();
			}
		},'->']
});

