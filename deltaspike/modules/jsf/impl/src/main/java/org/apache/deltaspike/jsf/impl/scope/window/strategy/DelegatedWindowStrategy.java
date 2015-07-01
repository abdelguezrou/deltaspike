/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.jsf.impl.scope.window.strategy;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Typed;
import javax.faces.context.FacesContext;
import org.apache.deltaspike.jsf.impl.scope.window.ClientWindowAdapter;

@Dependent
@Typed(DelegatedWindowStrategy.class)
public class DelegatedWindowStrategy extends AbstractClientWindowStrategy
{
    @Override
    protected String getOrCreateWindowId(FacesContext facesContext)
    {
        return ClientWindowAdapter.getWindowIdFromJsf(facesContext);
    }

    @Override
    public void disableClientWindowRenderMode(FacesContext facesContext)
    {
        facesContext.getExternalContext().getClientWindow().disableClientWindowRenderMode(facesContext);
    }

    @Override
    public void enableClientWindowRenderMode(FacesContext facesContext)
    {
        facesContext.getExternalContext().getClientWindow().enableClientWindowRenderMode(facesContext);
    }
    
    @Override
    public boolean isClientWindowRenderModeEnabled(FacesContext facesContext)
    {
        return facesContext.getExternalContext().getClientWindow().isClientWindowRenderModeEnabled(facesContext);
    }
}