Ext.define('Admin.view.authenticationApprove.AuthenticationApproveWindow', {
    extend: 'Ext.window.Window',
    //xtype: 'authenticationApproveWindow',
    alias: 'widget.authenticationApproveWindow',
    /*requires: [
        'Ext.form.RadioGroup',
        //'Ext.form.field.Radio', 
         'Ext.button.Button',
        'Ext.form.field.*',
        //'Ext.form.field.ComboBox',
        'Ext.form.Label'
        //'Ext.form.field.Checkbox',
        //'Ext.form.field.Text'
    ],*/
    height: 300,
    minHeight: 200,
    minWidth: 300,
    width: 500,
    scrollable: true,
    closable: true,
    constrain: true,
    title: '审核窗口',
    //defaultFocus: 'textfield',
    modal:true,
    layout: 'fit',
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        //ariaLabel: 'Add Department Information',
    	  items: [{
    		xtype: 'textfield',
		name: 'userName',
		bind:'{userName}',
		fieldLabel: 'userName',
        	hidden: true,
        	readOnly: true
	},{
            xtype: 'textfield',
            fieldLabel: '真实姓名',
		name: 'realName',
		bind: '{realName}',
		readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '身份证号',
            name:'idCardNumber',
            bind: '{idCardNumber}',
		readOnly: true
        },{
            xtype: 'textfield',
            fieldLabel: '身份证图片地址',
            name:'idCardPicture',
            bind: '{idCardPicture}',
		readOnly: true
		}]
		    }],

    buttons:  ['->',{
        xtype: 'button',
        text: 'Pass',
        handler: 'passApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'NoPass',
        handler: 'nopassApproveButton'//预留提交事件，在ViewController中实现。
	},'-',{
        xtype: 'button',
        text: 'Close',
        handler: function(button) {
            button.up('window').close();
        }
    }]
});
