using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;

namespace AdvDemo
{
    public class DatabaseDao
    {
        private static string strsqlcon = @"Data Source=192.168.87.62\SQL2005;Initial Catalog=db_autosense_logmgr;User ID=sa;Password=sa";
        private static string strsqlcon1 = @"Data Source=192.168.87.62\SQL2005;Initial Catalog=db_AutosenseUnion;User ID=sa;Password=sa";
        public static void execute(string strsqlcmd)
        {
            //SqlConnection con = new SqlConnection(strsqlcon);
            
            //SqlCommand cmd = new SqlCommand(strsqlcmd);
            //cmd.CommandTimeout = 0;
            //cmd.Connection = con;
            //con.Open();
            //cmd.BeginExecuteNonQuery();
            //con.Close();
        }


        internal static void execute1(string strsqlcmd)
        {
            SqlConnection con = new SqlConnection(strsqlcon1);
            SqlCommand cmd = new SqlCommand(strsqlcmd);
            cmd.Connection = con;
            con.Open();
            cmd.ExecuteNonQuery();
            con.Close();
        }
    }
}
