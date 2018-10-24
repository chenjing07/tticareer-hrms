Ext.define('Admin.view.employee.EmployeePanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'employeePanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.toolbar.Paging',
        'Ext.form.field.ComboBox',
        'Ext.selection.CheckboxModel',
        'Ext.grid.column.RowNumberer',
        'Ext.grid.column.Date'
    ],
    //controller: 'searchresults',
   // viewModel: {type: 'orderViewModel'},
    layout: 'fit',
    items: [{
            xtype: 'gridpanel',
            cls: 'user-grid',
            title: '员工信息管理',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{employeeLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'userName',text: '工号'},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'realName',text: '真实姓名'},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'iswork',text: '工作状态',
				renderer: function(val) {
		            if (val =='0') {
			            return '离职';
			        } else if (val =='1') {
			            return '正式';
			        }  else if (val =='2') {
			            return '实习';
			        } 
			        return val;}
			},
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkSatus',text: '审查状态' ,
				renderer: function(val) {
		            if (val =='1') {
			            return '<span style="color:green;">已通过审查</span>';
			        } else if (val =='0') {
			            return '<span style="color:blue;">待审查</span>';
			        } else{
			            return '<span style="color:red;">未通过审查</span>';
			        }
			        return val;}
			},		
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'phoneNumber',text: '手机号码',flex:1},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'gender',text: '性别',hidden:true,
				renderer: function(val) {
		            if (val =='1') {
			            return '男';
			        } else if (val =='0') {
			            return '女';
			        } 
			        return val;}
			},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'nation',text: '民族',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'nativePlace',text: '籍贯',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'registeredAddress',text: '户口地址',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'houseAddress',text: '家庭住址',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'education',text: '学历',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'academicDegree',text: '学位',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'major',text: '专业',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'tie',text: '系别',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'graduatedSchool',text: '毕业院校',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'graduatedTime',text: '毕业时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'politicalStatus',text: '政治面貌',hidden:true,
				renderer: function(val) {
		            if (val =='0') {
			            return '群众';
			        } else if (val =='1') {
			            return '中共党员';
			        }  else if (val =='2') {
			            return '中共预备党员';
			        }  else if (val =='3') {
			            return '共青团员';
			        }  else {
			            return '其他';
			        } 
			        return val;}
			},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'maritalStatus',text: '婚姻状况 ',hidden:true,
				renderer: function(val) {
		            if (val =='0') {
			            return '未婚';
			        } else if (val =='1') {
			            return '已婚';
			        }  
			        return val;}
			},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'recruitmentSource',text: '招聘来源',hidden:true,
				renderer: function(val) {
		            if (val =='0') {
			            return '简历应聘';
			        } else if (val =='1') {
			            return '招聘网站';
			        }  else if (val =='2') {
			            return '其它途径';
			        } 
			        return val;}
			},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'accountBank',text: '开户银行',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'accountNumber',text: '工资账户',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'email',text: '邮箱',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'qq',text: 'QQ号码',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'wechat',text: '微信号',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'msn',text: 'MSN',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'emergencyContactName',text: '紧急联系人姓名',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'emergencyContactRelationship',text: '紧急联系人关系',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'emergencyContactNumber',text: '紧急联系人电话',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'workStart',text: '入职时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'workEnd',text: ' 离职时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'practiceStart',text: '实习开始时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'practiceEnd',text: ' 实习结束时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'idCardNumber',text: '身份证号',hidden:true},
		   {xtype: 'datecolumn',cls:'content-column',dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'datecolumn',cls:'content-column',dataIndex: 'birthday',text: '出生年月',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'state',text: ' 状态',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: ' 备注',hidden:true},
			
			{xtype: 'actioncolumn',cls: 'content-column', width: 120,text: 'Actions',tooltip: 'edit ',
				items: [
					{xtype: 'button', iconCls: 'x-fa fa-pencil' ,handler: 'openEditWindow'},
					{xtype: 'button',iconCls: 'x-fa fa-close',handler: 'deleteOneRow'},
					{xtype: 'button',iconCls: 'x-fa fa-ban',handler: 'onDisableButton'}
				]
			}
            ],
            tbar: [		{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '工号', value: 'userName' },
								{ name: '真实姓名', value: 'realName' }]
							}),     
		                    displayField: 'name',
		                    valueField:'value',
							value:'userName',
							editable: false,
		                    queryMode: 'local',
		                    triggerAction: 'all',
		                    emptyText: 'Select a state...',
		                    width: 135,
		                    listeners:{
								select: 'searchComboboxSelectChuang'
							}
		                },'-', {
		                     xtype:'textfield',
		                     reference:'searchFieldValue',
							 name:'employeePanelSearchField'
		                } ,'-', {
		                     xtype:'textfield',            
							 reference:'searchFieldValue1',
							 hidden :true,
							 name:'employeePanelSearchField1',
							 
		                },'-',{
							text: 'Search',
							iconCls: 'fa fa-search',
							handler: 'quickSearch'
						},'-',{
				        text: 'Search More',
				        iconCls: 'fa fa-search-plus',
				        handler: 'openSearchWindow'	
				    },'->',{
				        text: 'Add',
				        tooltip: 'Add a new row',
				        iconCls: 'fa fa-plus',
				        handler: 'openAddWindow'	
				    },'-',{
				        text: 'Removes',
				        tooltip: 'Remove the selected item',
				        iconCls:'fa fa-trash',
				        itemId:'employeeGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{employeeLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#employeeGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
