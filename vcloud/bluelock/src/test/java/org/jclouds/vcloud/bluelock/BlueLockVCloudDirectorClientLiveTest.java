/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either director or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.vcloud.bluelock;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Properties;

import org.jclouds.compute.ComputeServiceContextFactory;
import org.jclouds.logging.log4j.config.Log4JLoggingModule;
import org.jclouds.vcloud.VCloudClientLiveTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

/**
 * Tests behavior of {@code BlueLockVCloudClient}
 * 
 * @author Adrian Cole
 */
@Test(groups = "live", sequential = true, testName = "bluelock.BlueLockVCloudDirectorClientLiveTest")
public class BlueLockVCloudDirectorClientLiveTest extends VCloudClientLiveTest {

   @BeforeGroups(groups = { "live" })
   @Override
   public void setupClient() {
      identity = checkNotNull(System.getProperty("bluelock-vcdirector.identity"),
               "bluelock-vcdirector.identity");
      String credential = checkNotNull(System.getProperty("bluelock-vcdirector.credential"),
               "bluelock-vcdirector.credential");
      context = new ComputeServiceContextFactory().createContext("bluelock-vcdirector", identity, credential, ImmutableSet
               .<Module> of(new Log4JLoggingModule()), new Properties()).getProviderSpecificContext();
      connection = context.getApi();
   }

}
