/*
 * Encog(tm) Core v3.2 - Java Version
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 
 * Copyright 2008-2012 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *   
 * For more information on Heaton Research copyrights, licenses 
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package org.encog.util;

import org.encog.mathutil.error.ErrorCalculation;

import junit.framework.TestCase;

public class TestErrorCalculation extends TestCase {

	public void testErrorCalculation()
	{
		double ideal[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16} };
		
		double actual_good[][] = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16} };
		
		double actual_bad[][] = {
				{1,2,3,5},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16} };
		
		ErrorCalculation error = new ErrorCalculation();
		
		for(int i=0;i<ideal.length;i++)
		{
			error.updateError(actual_good[i], ideal[i], 1.0);
		}
		TestCase.assertEquals(0.0,error.calculateRMS());
		
		error.reset();
		
		for(int i=0;i<ideal.length;i++)
		{
			error.updateError(actual_bad[i], ideal[i], 1.0);
		}
		TestCase.assertEquals(250,(int)(error.calculateRMS()*1000));
		
	}
}
