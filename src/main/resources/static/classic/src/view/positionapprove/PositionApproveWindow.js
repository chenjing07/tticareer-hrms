Ext.define('Admin.view.positionapprove.PositionApproveWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.positionApproveWindow',

    y:10, 
	height:400, 
	width:500,
    //minHeight: 10,
    //minWidth: 300,
    scrollable: true,
    title: '审批窗口',
    closable: true,
    modal:true, //打开窗口后 不能操作其他模块
    
    layout: 'fit',
    
    items: [{
		scrollable: true,
        xtype: 'form',
        layout: 'form',
        padding: '10px',
        ariaLabel: 'Add Position Information',
        items: [{
            xtype: 'textfield',
            fieldLabel: 'id',
            name:'id',
            hidden: true,
            readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '部门id',
            name:'departmentId',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '岗位编号',
            name:'positionNumber',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '岗位名称',
            name:'positionName',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '上级岗位id',
            name:'superiorPositionid',
			readOnly: true
        }, {
            xtype: 'textfield',
            fieldLabel: '岗位简介',
            name:'positionIntroduction',
			readOnly: true
        }, {
            xtype: 'datefield',
            fieldLabel: '创建日期',
            name:'createTime',
			format: 'Y/m/d H:i:s',
			readOnly: true
        },/* {
            xtype: 'textfield',
            fieldLabel: '状态',
            name:'state',
			readOnly: true
        },
        {
            xtype: 'textfield',
            fieldLabel: '审查状态',
            name:'checkStatus',
			readOnly: true
        }, */{
            xtype: 'textfield',
            fieldLabel: '备注',
            name:'note',
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

