

function ListGroup() {

    let items = [
        "New York", "San Fransisco",
        "Tokyo", "London"
    ]

    //items = [];

    return (
    // <> for returning Fragment (aka. mutliple return values).
    <> 
        <h1>  List </h1>
        <ul className="list-group">

            {items.length == 0 && <p>No Item Found</p>}

            {items.map(item => (    // Declare function with =>
                <li className="list-group-item" key={item}> {item} </li>
            ))}

        </ul>
    </>
  );
}

export default ListGroup;
