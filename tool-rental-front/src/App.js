import React from 'react';
import './App.css';

export const ToolAvailable = ({ toolId, toolName, toolDescription }) => {

  const handleClick = async () =>{
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        user:{idUser:1},
        tool:{idTool:toolId}
      })
    };
    await fetch('http://127.0.0.1:8080/rental', requestOptions);
  }

  return (
    <li className="toolAvilable list-group-item">
      <div className='row'>
        <div className='col-10'><h5>{toolName}</h5></div>
        <div className='col-1'>
          <button className="btn btn-primary btn-sm"  onClick={handleClick} title="Tooltip on top">+</button></div>
        </div>
        <div className="row text-secondary"><p>{toolDescription}</p></div>
    </li>
  );
}

export const SideBar = () => {

  //crea la variable para almacenar las tools
  const [tools, setTools] = React.useState([]);

  // Obtiene las tools del api
  const obtenerTools = async () => {
    const data = await fetch('http://127.0.0.1:8080/availableTools');
    if(data){
      setTools(await data.json());
    }
  }

  //actualiza las tools
  React.useEffect(() => {
    obtenerTools();
  }, [])

  //crea la lista de tools a nivel de List items html
  const toolsList = tools.map(tool =>
    <ToolAvailable key={tool.idTool} toolId={tool.idTool} toolName={tool.toolName} toolDescription={tool.toolDescription} />
  )

  //retorna el componente side bar
  return (
    <div className="card">
      <div className="card-body">
        <h4 className="card-title">Tools for rental</h4>
      </div>
      <ul className="list-group list-group-flush">
        {toolsList}
      </ul>
    </div>
  )
}

export const UserInfo = ({ userId, userName, urlImageUser }) => {
  return (
    <div id='userInfo' className='row'>
      <div className='col-2'>
        <div className="media">
          <a className=" align-self-center" href="http://localhost:3000/">
            <img height='100vh' src={urlImageUser} alt="" />
          </a>
        </div>
      </div>
      <div className='col-10'>
        <div className='row'>
          <div className='col-10 p-4'><h2>{userName}</h2></div>
          <div className='col-1 p-4'>
            <a className="btn btn-secondary btn-sm" href="Jumbo action link" role="button">Edit</a></div>
        </div>
      </div>
      <hr className="my-2" />
    </div>
  );
}

export const RentedTool = ({ idRental, toolName, toolDescription }) => {
  const handleClick = async () =>{
    const requestOptions = {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        idRental:idRental
      })
    };
    await fetch('http://127.0.0.1:8080/rental', requestOptions);
  }

  return (
    <div id='toolRented' className='row'>
      <div className='col-3'>
        <div className="border border-secondary rounded">
          <h4 className='text-center'>{toolName}</h4>
        </div>
      </div>
      <div className='col-9'>
        <div className='row'>
          <div className='col-10 text-secondary'><h5>{toolDescription}</h5><h6>Delivery date: 13 dias</h6></div>
          <div className='col-1'>
            <a className="btn btn-primary btn-sm" href="Jumbo action link" role="button" onClick={handleClick}>return</a></div>
        </div>
      </div>
      <hr className="my-2" />
    </div>
  );
}

export const RentedTools = ({userId}) => {

  const [rentedTools, setRentedTools] = React.useState([]);
  // Obtiene las tools del api
  const obtenerRentedTools = async () => {
    const data = await fetch(`http://127.0.0.1:8080/rentalsById?idUser=${userId}`);
    if(data){
      setRentedTools(await data.json());
    }
  }

  //actualiza las tools
  React.useEffect(() => {
    obtenerRentedTools();
  })

  //crea la lista de tools a nivel de List items html
  const rentedToolsList = rentedTools.map(rental =>
    <RentedTool key={rental.idRental} idRental={rental.idRental} toolName={rental.tool.toolName} toolDescription={rental.tool.toolDescription} />
  )

  return (
    <div id='rentedTools'>
      {rentedToolsList}
    </div>
  );
}

function App() {
  return (
    <div className='container'>
      <div id='toolbar' className='row'>
        <div className="p-5 jumbotron">
          <h1 className="display-3">ToolRental</h1>
          <hr className="my-2" />
        </div>
      </div>
      <div className='row'>
        <div id='sidebar' className='col-4'>
          <SideBar />
        </div>
        <div id='content' className='col-8'>
          <UserInfo userId='1' userName='Alejandro Rodriguez' urlImageUser='https://www.saccsa.com.mx/wp-content/uploads/2017/02/avatar-round-3.png' />
          <RentedTools userId='1'/>
        </div>
      </div>
    </div>
  );
}

export default App;