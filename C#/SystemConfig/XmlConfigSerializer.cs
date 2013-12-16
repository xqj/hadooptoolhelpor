using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;
using System.IO;
using System.Xml;

namespace SystemConfig
{
   public class XmlConfigSerializer
    {
       private static XmlConfigSerializer _instance = new XmlConfigSerializer();
       public static XmlConfigSerializer Instance
       {
           get
           {
               return _instance;
           }
       }
       private XmlConfigSerializer()
       {

       }
       public void Serializer<T>(string file, List<T> list)
       {
           XmlSerializer ser = new XmlSerializer(typeof(List<T>));
           FileStream stream = new FileStream(file, FileMode.OpenOrCreate);
           ser.Serialize(stream, list);           
       }
       public List<T> Deserialize<T>(string file)
       {
           XmlSerializer ser = new XmlSerializer(typeof(List<T>));
           XmlReaderSettings settings = new XmlReaderSettings();
           settings.ConformanceLevel = ConformanceLevel.Fragment;
           settings.IgnoreWhitespace = true;
           settings.IgnoreComments = true;
           XmlReader reader = XmlReader.Create(file, settings);
           List<T> list=null;
           if (ser.CanDeserialize(reader))
               list = (List<T>)ser.Deserialize(reader);
           return list;
       }
    }
}
