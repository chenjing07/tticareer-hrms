
Ext.define('Admin.view.department.DepartmentPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'departmentPanel',

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
            title: '部门管理',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{departmentLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentNumber',text: '部门编号'},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentName',text: '部门名称'},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'departmentIntroduction',text: '部门简介',flex:1},
           {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'checkStatus',text: '审查状态' ,
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
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'superiorDepartmentId',text: '上级部门ID',hidden:true,
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/department/getDepartmentNameById', 
					   method:'get', 
					   params:{id:val}, 
					  async: false,
					   success:function(response, options) {
          					var json = Ext.util.JSON.decode(response.responseText);
          					if (json.data) {
            					result = json.data;
								//console.log(result);
         				 	}
						}
					});
					return result;
			    }
		},
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'state',text: ' 状态',hidden:true},
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'note',text: ' 备注',hidden:true},
			{xtype: 'gridcolumn',cls:'content-column',width: 160,dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
           
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
									{ name: '部门编号', value: 'departmentNumber' },
									{ name: '部门名称', value: 'departmentName' }
								]
							}),     
		                    displayField: 'name',
		                    valueField:'value',
							value:'departmentNumber',
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
							name:'departmentPanelSearchField'
		                } ,'-', {
		                    xtype:'datefield',            
							reference:'searchFieldValue1',
							hidden :true,
							name:'departmentPanelSearchField1'
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
							itemId:'departmentGridPanelRemove', 
							disabled: true,
							handler: 'deleteMoreRows'	     			 
						}
				],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{departmentLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#departmentGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
