package Nodes;

import Nodes.Events.IEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles nodes
 */
public class NodesHandler {

    /**
     * Singleton implementation
     */
    public static final NodesHandler INSTANCE = new NodesHandler();

    /**
     * Events map
     */
    private Map<String,IEvent> events;

    /**
     * Actions map
     */
    private Map<String,IAction> actionMap;

    /**
     * Parameter map
     */
    private Map<String,IParameter> parameterMap;

    /**
     * Primitives map
     */
    private Map<String,IPrimitive> primitiveMap;

    /**
     * Singleton implementation
     */
    private NodesHandler(){
        this.events = new HashMap<>();
        this.actionMap = new HashMap<>();
        this.parameterMap = new HashMap<>();
        this.primitiveMap = new HashMap<>();
    }

    /**
     * registers nodes
     * @param nodes given nodes
     */
    public void register(INode... nodes){
        for (INode node : nodes)
            register(node);
    }

    public void register(INode obj){
        if(obj instanceof IAction)
            putInMap(actionMap,(IAction) obj);
        else if(obj instanceof IParameter)
            putInMap(parameterMap,(IParameter) obj);
        else if(obj instanceof IPrimitive)
            putInMap(primitiveMap,(IPrimitive) obj);
        else if(obj instanceof IEvent)
            putInMap(events,(IEvent) obj);
    }

    private <T> void putInMap(Map<String,T> map,T obj){
        map.put(obj.getClass().getSimpleName(),obj);
    }

    /**
     *
     * @return a copy of the registered events map
     */
    public Map<String, IEvent> getEvents() {
        return new HashMap<>(events);
    }

    /**
     *
     * @return a copy of the registered actions map
     */
    public Map<String, IAction> getActionMap() {
        return new HashMap<>(actionMap);
    }

    /**
     *
     * @return a copy of the registered parameters map
     */
    public Map<String, IParameter> getParameterMap() {
        return new HashMap<>(parameterMap);
    }

    /**
     *
     * @return a copy of the registered primitives map
     */
    public Map<String, IPrimitive> getPrimitiveMap() {
        return new HashMap<>(primitiveMap);
    }
}