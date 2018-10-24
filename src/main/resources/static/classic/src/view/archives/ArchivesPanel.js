Ext.define('Admin.view.archives.ArchivesPanel', {
    extend: 'Ext.panel.Panel',
    xtype: 'archivesPanel',

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
            title: '档案管理',
            selModel: {type: 'checkboxmodel',checkOnly: true},
            //routeId: 'user',
            bind: '{archivesLists}',
            scrollable: false,
            columns: [
           {xtype: 'gridcolumn',width: 40,dataIndex: 'id',text: 'id',hidden:true},
       	   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'employeeId',text: '员工Id',
				renderer: function(val) {
				   var result;
		           Ext.Ajax.request({
					   url:'/employee/getEmployeeNameById', 
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
		   {xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'inTime',text: '入职时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
		   {xtype: 'gridcolumn',cls:'content-column',dataIndex: 'archivesSource',text: '档案来源',flex:1},
		   {xtype: 'gridcolumn',cls:'content-column',width: 160,dataIndex: 'createTime',text: '创建时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
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
			{xtype: 'datecolumn',cls: 'content-column', width: 160,dataIndex: 'outTime',text: '离职时间',renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s'),hidden:true},
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'archivesDestination',text: ' 档案去处',hidden:true},
			{xtype: 'gridcolumn',cls:'content-column',dataIndex: 'archivesChange',text: ' 档案变更说明',hidden:true},
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
            tbar: [{ 
		                    xtype: 'combobox',
		                    reference:'searchFieldName',
		                    hideLabel: true, 
		                    store:Ext.create("Ext.data.Store", {
						    fields: ["name", "value"],
						    data: [
						      	{ name: '员工工号', value: 'userName' },
								{ name: '创建时间', value: 'createTime' }
						    ]
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
            			 name:'archivesPanelSearchField'
		                } ,'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue1',
            		 	  hidden :true,
            			  name:'archivesPanelSearchDateField1',
            			 format: 'Y/m/d H:i:s'
		                },'-', {
		                     xtype:'datefield',            
            			  reference:'searchDateFieldValue2',
            		 	  hidden :true,
            			  name:'archivesPanelSearchDateField2',
            			  format: 'Y/m/d H:i:s'
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
				        itemId:'archivesGridPanelRemove', 
				        disabled: true,
				        handler: 'deleteMoreRows'	     			 
		}
],	
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                //itemId: 'userPaginationToolbar',
                displayInfo: true,
                bind: '{archivesLists}',
            }],
            listeners:{selectionchange:function(selModel, selections) {
  				this.down('#archivesGridPanelRemove').setDisabled(selections.length === 0);}}
        }]
});
